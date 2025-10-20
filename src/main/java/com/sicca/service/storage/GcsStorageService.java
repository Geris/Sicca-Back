package com.sicca.service.storage;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class GcsStorageService {

    private final Storage storage;
    private final String bucketName;

    public GcsStorageService(@Value("${gcs.bucket}") String bucketName,
                             @Value("${gcs.project-id:}") String projectId) {
        StorageOptions options = (projectId == null || projectId.isEmpty())
                ? StorageOptions.getDefaultInstance()
                : StorageOptions.newBuilder().setProjectId(projectId).build();
        this.storage = StorageOptions.getDefaultInstance().getService();
        this.bucketName = bucketName;
    }

    public String uploadImage(MultipartFile file, Map<String, String> metadata) throws IOException {
        String original = file.getOriginalFilename() == null ? "file" : file.getOriginalFilename();
        String objectName = "images/" + UUID.randomUUID().toString() + "_" + original;

        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(file.getContentType())
                .setMetadata(metadata)
                .build();

        storage.create(blobInfo, file.getBytes());
        return "gs://" + bucketName + "/" + objectName;
    }
}
