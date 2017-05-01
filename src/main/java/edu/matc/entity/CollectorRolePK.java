package edu.matc.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by David on 3/14/17.
 */
@Embeddable
public class CollectorRolePK implements Serializable {
  String role_name;
  String email;
}