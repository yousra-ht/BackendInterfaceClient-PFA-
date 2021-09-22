package com.example.demo.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "DownloadFile")
@ComponentScan()
public class DownloadFile implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(generator = "uuid")
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	private String type;
 
	
	
	@Lob
	   private byte[] data;
	   public DownloadFile() {
	   }

	   public DownloadFile (String name, String type, byte[] data) {
	     this.name = name;
	     this.type = type;
	     this.data = data;
	   }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "DownloadFile [id=" + id + ", name=" + name + ", type=" + type + ", data=" + Arrays.toString(data)
					+ "]";
		}

	


}
