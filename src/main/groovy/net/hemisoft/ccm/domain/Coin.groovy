package net.hemisoft.ccm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coin {
	@Id @GeneratedValue		Long 	id;
							String 	coinId;
							String 	name;
							String 	symbol;
							Integer rank;
}
