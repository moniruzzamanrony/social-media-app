package com.assignment.socialmediabackend.constents;

public interface SharePostConstent {

    String STATUS = "/status";
    String POST_STATUS = STATUS + "/create";
    String GET_MY_STATUS = "/my" + STATUS;
    String GET_MY_STATUS_BY_ID = "/my" + STATUS + "/{id}";
}
