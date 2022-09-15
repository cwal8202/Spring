package kr.co.greenart.model.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	private final File saveFolder = new File("d:\\temp\\");
	private final Path root = Paths.get("d:\\temp\\");
	
	@Override
	public Resource getByName(String fileName) {
		try {
			return new UrlResource(new File(saveFolder.getAbsolutePath()
					+ File.separatorChar
					+ fileName).toURI());
		} catch (MalformedURLException e) {
			return null;
		}
	}

	@Override
	public List<String> getAllnames() {
		File[] filearr = saveFolder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return !pathname.isDirectory();
			}
		});
		List<String> list = new ArrayList<>();
		for (File f : filearr) {
			list.add(f.getName());
		}
		
		return list;
		
//		try {
//			return Files.walk(root, 1)
//				.filter(t -> !t.equals(root))
//				.filter(x -> !Files.isDirectory(x))
//				.map(y -> y.toString())
//				.collect(Collectors.toList());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public int save(MultipartFile file) {
		if (!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		try {
			file.transferTo(new File(saveFolder.getAbsolutePath()
					+ File.separatorChar
					+ file.getOriginalFilename()));
			return 1;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return 0;
		}
		
//		Path saveFolder = Paths.get("d:\\");
//		try {
//			if (!Files.exists(saveFolder)) {
//				Files.createDirectories(saveFolder);
//			}
//			file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename())).normalize());
//			return 1;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return 0;
//		}
		
	}
}










