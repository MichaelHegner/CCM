package net.hemisoft.ccm.domain;

import javax.persistence.Column
import javax.persistence.Entity;
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table
import javax.persistence.UniqueConstraint

import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@Entity
@EntityListeners(AuditingEntityListener)
@Audited
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
	
	@Column(name = "created_date", nullable = false, updatable = false)
	@CreatedDate
	private long createdDate;
 
	@Column(name = "modified_date")
	@LastModifiedDate
	private long modifiedDate;
}
