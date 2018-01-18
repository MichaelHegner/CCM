package net.hemisoft.ccm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType
import javax.persistence.Id;
import javax.persistence.Table
import javax.persistence.UniqueConstraint

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@Entity
@Table(
	uniqueConstraints=
		@UniqueConstraint(columnNames= ["coinId", "name"])
)
@EqualsAndHashCode(includes = ["coinId", "name"])
@ToString
public class Coin {
	@Id @GeneratedValue	
	Long 	id;
	String 	coinId;
	String 	name;
	String 	symbol;
	Integer rank; // TODO: Move to CoinOnMarketPlace
}
