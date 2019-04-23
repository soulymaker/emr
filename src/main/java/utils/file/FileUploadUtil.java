package utils.file;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;

//文件上传
@Component
public class FileUploadUtil {
    private FileUploadUtil() {
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
        System.out.println("上传成功");
    }
}
