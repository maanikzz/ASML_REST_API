package com.ASML.SpringbootDownload.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class FileInfo {
	    @JsonProperty("name")
		private String name;
	    
	    @JsonProperty("url")
		private String url;
	    
		@Builder
		@JsonCreator
		public FileInfo(@JsonProperty("name") String name,
				        @JsonProperty("url") String url)
	    {
			this.name = name;
			this.url = url;
		}

		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}


}
