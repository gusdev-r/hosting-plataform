package com.academydevgus.hostingplataform.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
 class RoomControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addNewRoom_createsANewRoomAtTheDataBase_whenSuccessful() throws Exception {
        MockMultipartFile photoFile = new MockMultipartFile("photo",
                "photo.jpg", "image/jpeg", "photo content".getBytes());

        mockMvc.perform(multipart("/v1/api/rooms/add/new-room")
                .file(photoFile)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .param("roomType", "Double bad")
                .param("roomPrice", "1400")
        ).andExpect(status().isOk());
    }
}
