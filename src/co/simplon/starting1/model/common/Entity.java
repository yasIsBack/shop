package co.simplon.starting1.model.common;

import java.io.Serializable;
import java.util.UUID;

public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id = UUID.randomUUID().toString();

    public String getId() {

	return id;
    }

    public void setId(String id) {

	this.id = id;
    }

}
