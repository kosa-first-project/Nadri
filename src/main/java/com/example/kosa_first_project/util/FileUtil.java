package com.example.kosa_first_project.util;

import com.example.kosa_first_project.domain.board.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// 파일 가지고와서 출력한다.
public class FileUtil {
    public static List<FileDTO> uploadFile(MultipartFile[] uploadFile){
        List<FileDTO> list = new ArrayList<>();

        for (MultipartFile file : uploadFile) {
            if (!file.isEmpty()) { // 파일이 존재하면 UUID를 이용해 고유한 파일 이름을 만들어준다.
                FileDTO FileDTO = new FileDTO();
                FileDTO.setFileName(UUID.randomUUID().toString());
                FileDTO.setFileName(file.getOriginalFilename());
                FileDTO.setContentType(file.getContentType());

                list.add(FileDTO); // 파일 객체 추가

                File newFileName = new File(FileDTO.getUuid() + "_" + FileDTO.getFileName()); // 파일 이름 생성
                try {
                    file.transferTo(newFileName); // 전송
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
