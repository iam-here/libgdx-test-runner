package com.binarytweed.libgdx.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

@RunWith(LibGdxTestRunner.class)
public class LibGdxTest
{	
	@Test
	public void appListenerIsLoaded()
	{
		System.out.println("Test Classloader according to test: "+getClass().getClassLoader());
		System.out.println("GDX Classloader according to test: "+Gdx.class.getClassLoader());
		ApplicationListener app = Gdx.app.getApplicationListener();
		assertThat(app, notNullValue());
	}
	
	
	@Test
	public void localStorageIsWritableAndReadable()
	{
		FileHandle writeHandle = Gdx.files.local("foo");
		writeHandle.writeString("bar", false);
		
		FileHandle readHandle = Gdx.files.local("foo");
		String actual = readHandle.readString();
		assertThat(actual, is("bar"));
		
		boolean deleted = readHandle.delete();
		assertThat(deleted, is(true));
	}
	
	
	@Test
	public void textureCanBeDrawn()
	{
		Texture texture = new Texture("fixtures/texture.png");
		SpriteBatch spriteBatch = new SpriteBatch();
		spriteBatch.begin();
		spriteBatch.draw(texture, 0f, 0f);
		spriteBatch.end();
	}
}
