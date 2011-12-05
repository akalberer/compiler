package ch.ntb.inf.deep.launcher;

import ch.ntb.inf.deep.classItems.Type;
import ch.ntb.inf.deep.host.ErrorReporter;
import ch.ntb.inf.deep.linker.Linker32;

/**
 * Launcher for tests only! Adept this file to your configuration, but don't commit
 * those changes to the SVN! Please store your project file in the top folder of
 * the deep-Project. You can find an example project "ExampleProject.deep" in
 * this folder which you may use as base for your own test project.
 */
public class TestLauncher {
	public static void main(String[] args) {
//		Launcher.buildAll("D:/work/Project_deep/deep/ExampleProject.deep", "BootFromRam");
//		Launcher.buildAll("D:/work/Project_deep/deep/ExampleProject.deep", "BootFromFlash");
		Launcher.buildAll("D:/work/Project_deep/deep/jUnitTargetTests.deep", "BootFromRam");

		/* DOWNLOAD TO TARGET */
		if (ErrorReporter.reporter.nofErrors == 0) {
			Launcher.downloadTargetImage();
			Launcher.startTarget();
		}
		
		/* SAVE TO FILE */
		Launcher.saveCommandTableToFile("D:/work/Project_deep/junitTarget/tct/commandTable.dtct");
//		Launcher.saveTargetImage2File("C:/temp/deep_example_target_image.dtim");
		
		/* DEBUG OUTPRINTS */
		System.out.println("%%%%%%%%%%%%%%% Class List %%%%%%%%%%%%%%%"); Linker32.printClassList(false, false, false, true);
		System.out.println("%%%%%%%%%%%%%%% System Table %%%%%%%%%%%%%%%"); Linker32.printSystemTable();
//		System.out.println("%%%%%%%%%%%%%%% Global Constants %%%%%%%%%%%%%%%"); Linker32.printGlobalConstantTable();		
//		System.out.println("%%%%%%%%%%%%%%% Target Image (Full image) %%%%%%%%%%%%%%%"); Linker32.printTargetImage();
//		System.out.println("%%%%%%%%%%%%%%% Target Image (Segment List) %%%%%%%%%%%%%%%"); Linker32.printTargetImageSegmentList();	
//		System.out.println("%%%%%%%%%%%%%%% Memory Map %%%%%%%%%%%%%%%"); MemoryMap.getInstance().println(1);
//		System.out.println("%%%%%%%%%%%%%%% Configuration %%%%%%%%%%%%%%%"); Configuration.print();
		
	}
}
