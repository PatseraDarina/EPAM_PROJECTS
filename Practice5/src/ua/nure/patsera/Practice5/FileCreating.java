package ua.nure.patsera.Practice5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCreating extends Thread {

	public static RandomAccessFile raf;

	private String path;

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public FileCreating(String path) {
		setPath(path);
	}

	void fileCreating() throws IOException {
		File file = new File(getPath());
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		raf = new RandomAccessFile(file, "rw");
	}

	@Override
	public void run() {
		try {
			fileCreating();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
