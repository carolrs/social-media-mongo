package io.carolrs.socialmedia.socialmedia.domain.resource.service.exceptions;

    public class ObjectNotFoundException extends RuntimeException {
        public ObjectNotFoundException(String msg){
            super(msg);
        }
}
