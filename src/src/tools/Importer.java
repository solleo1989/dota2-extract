package tools;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.*;

public class Importer {

	private final static String root_directory = "/media/mtc/Data/Extract files/root";
	private final static String image_directory = "/resource/flash3/images/";
	private final static String infor_directory = "/scripts/npc/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inforSrc = root_directory + infor_directory;
		String inforDst = "root" + infor_directory;
		String imageSrc = root_directory + image_directory;
		String imageDst = "root" + image_directory;
		try {
			copyFiles(inforSrc, inforDst);
			copyFiles(imageSrc, imageDst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void copyFiles(String src, String dst) throws IOException {
		final Path srcPath = FileSystems.getDefault().getPath(src); // source
		final Path dstPath = FileSystems.getDefault().getPath(dst); // target
		System.out.println("Copy files from: " + srcPath.toString());
		System.out.println("             to: " + dstPath.toString());

		Files.walkFileTree(srcPath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
				Files.createDirectories(dstPath.resolve(srcPath.relativize(dir)));
				return FileVisitResult.CONTINUE;
			}
			@Override
			public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
				Files.copy(file, dstPath.resolve(srcPath.relativize(file)), StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
				return FileVisitResult.CONTINUE;
			}
		});
	}

}
