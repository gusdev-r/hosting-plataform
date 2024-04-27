package com.academydevgus.hostingplataform.service;

import com.academydevgus.hostingplataform.domain.Room;
import com.academydevgus.hostingplataform.repository.RoomRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ImpRoomServiceUnitTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private ImpRoomService impRoomService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("addNewRoom(), create a new room when everything is ok")
    void addNewRoomTest() throws SQLException, IOException {
        String roomType = "Double bed";
        BigDecimal roomPrice = new BigDecimal("1400");
        Room roomExpected = new Room();
        roomExpected.setRoomType(roomType);
        roomExpected.setRoomPrice(roomPrice);

        MockMultipartFile photoFile = new MockMultipartFile("photo",
                "photo.jpg", "image/jpeg", "photo content".getBytes());

        assertThatNoException().isThrownBy(() -> impRoomService
                .addNewRoom(photoFile, roomType, roomPrice));

        assertNotNull(roomRepository.findAll());

    }
}