package pneumatter.vitaeessentia;

import java.util.UUID;

public enum UUIDHelper {
    MAX_HEALTH(UUID.fromString("12345678-1234-1234-1234-123456789012")),
    MOVEMENT_SPEED(UUID.fromString("12345678-1234-1234-1234-123456789012"));

    UUID id;

    UUIDHelper(UUID id){
        this.id = id;
    }

    public UUID getId(){
        return id;
    }
}
