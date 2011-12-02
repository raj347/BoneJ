package org.doube.bonej;

import static org.junit.Assert.*;
import ij.ImagePlus;

import org.doube.geometry.TestDataMaker;
import org.junit.Test;

public class VolumeFractionTest {
	private final ImagePlus rod = TestDataMaker.rod(256, 64);
	private final ImagePlus sphere = TestDataMaker.sphere(64);
	private final ImagePlus brick = TestDataMaker.brick(32, 64, 96);
	private VolumeFraction vf = new VolumeFraction();
	private final double[] expectedRod = { 256 * Math.PI * 32 * 32,
			256 * 128 * 128 };
	private final double[] expectedSphere = { 4 * Math.PI * 64 * 64 * 64 / 3,
			130 * 130 * 131 };
	private final double[] expectedBrick = { 32 * 64 * 96, 34 * 66 * 98 };

	@Test
	public void testGetVolumesImagePlusDoubleDouble() {
		double[] vols = vf.getVolumes(rod, 1, 255);
		assertArrayEquals(expectedRod, vols, 3000);

		vols = vf.getVolumes(sphere, 1, 255);
		assertArrayEquals(expectedSphere, vols, 2000);

		vols = vf.getVolumes(brick, 1, 255);
		assertArrayEquals(expectedBrick, vols, 0);
	}

	@Test
	public void testGetVolumesImagePlusDoubleDoubleBoolean() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetSurfaceVolumeImagePlusDoubleDoubleInt() {
		double[] vols = vf.getSurfaceVolume(rod, 1, 255, 1);
		assertArrayEquals(expectedRod, vols, 3000);

		vols = vf.getSurfaceVolume(sphere, 1, 255, 1);
		assertArrayEquals(expectedSphere, vols, 2000);

		vols = vf.getSurfaceVolume(brick, 1, 255, 1);
		assertArrayEquals(expectedBrick, vols, 200);
	}

	@Test
	public void testGetSurfaceVolumeImagePlusDoubleDoubleIntBooleanBoolean() {
		fail("Not yet implemented"); // TODO
	}

}
