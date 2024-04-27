package com.academydevgus.hostingplataform.controller;

import com.academydevgus.hostingplataform.domain.Room;
import com.academydevgus.hostingplataform.dto.response.RoomResponse;
import com.academydevgus.hostingplataform.repository.RoomRepository;
import com.academydevgus.hostingplataform.service.ImpRoomService;
import jakarta.persistence.ManyToOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class RoomControllerUnitTest {

    @Mock
    private ImpRoomService impRoomService;
    @Mock
    private RoomRepository roomRepository;
    @InjectMocks
    private RoomController roomController;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("addNewRoom(), get the request and return the RoomResponse with 200 code")
    void addNewRoom() throws SQLException, IOException {
        MockMultipartFile photoFile = new MockMultipartFile("photo",
                "photo.jpg", "image/jpeg", "photo content".getBytes());
        String roomType = "Single bed";
        BigDecimal roomPrice = new BigDecimal("200");

        Room savedRoom = new Room();
        savedRoom.setId(1L);
        savedRoom.setRoomPrice(roomPrice);
        savedRoom.setRoomType(roomType);

        BDDMockito.lenient().when(impRoomService.addNewRoom(photoFile, roomType, roomPrice))
                .thenReturn(savedRoom);
        ResponseEntity<RoomResponse> responseEntity = roomController.addNewRoom(photoFile, roomType, roomPrice);

        var responseRoom = responseEntity.getBody();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseRoom).isNotNull();
        assertThat(responseRoom.getRoomType()).isEqualTo(roomType);
        assertThat(responseRoom.getRoomPrice()).isEqualTo(roomPrice);

    }
}