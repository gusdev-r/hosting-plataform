package com.academydevgus.hostingplataform.service;

import com.academydevgus.hostingplataform.domain.Room;
import com.academydevgus.hostingplataform.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class ImpRoomService implements RoomService {

    private RoomRepository roomRepository;

    public ImpRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public ImpRoomService() {
    }

    @Override
    public Room addNewRoom(MultipartFile photoFile, String roomType,
                           BigDecimal roomPrice)
            throws SQLException, IOException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        if (!photoFile.isEmpty()) {
            byte[] photoBytes = photoFile.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            room.setPhoto(photoBlob);
        }
        return roomRepository.save(room);
    }
}
