package com.academydevgus.hostingplataform.controller;

import com.academydevgus.hostingplataform.domain.Room;
import com.academydevgus.hostingplataform.dto.response.RoomResponse;
import com.academydevgus.hostingplataform.service.ImpRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping(path = {"/v1/api/rooms", "/v1/api/rooms/"})
@RequiredArgsConstructor
public class RoomController {

    private final ImpRoomService impRoomService;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = impRoomService.addNewRoom(photo, roomType, roomPrice);

        RoomResponse roomResponse = new RoomResponse(savedRoom.getId(),
                savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(roomResponse);
    }

}
