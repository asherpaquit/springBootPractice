package com.g1.appdev.francis_and_friends.project;

import java.sql.Date;
import java.time.LocalDateTime;

public record ProjectDetails (
    Integer projectId,
    String title,
    String description,
    String status,
    LocalDateTime deadline
){

}
