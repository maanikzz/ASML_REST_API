package com.ASML.SpringbootDownload.model;

import java.util.List;

public class ImageWrapper {
	
	private List<FileInfo> images;
	

	public ImageWrapper() {
		super();
	}

	public ImageWrapper(List<FileInfo> images) {
		super();
		this.images = images;
	}

	public List<FileInfo> getImages() {
		return images;
	}

	public void setImages(List<FileInfo> images) {
		this.images = images;
	}
	

}
