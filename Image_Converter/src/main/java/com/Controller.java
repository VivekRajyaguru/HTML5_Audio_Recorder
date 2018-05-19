package com;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Base64.Decoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@PostMapping	
	public void convertImage(@RequestParam("imageValue") String baseString, HttpServletRequest request) throws Exception {
		Decoder decoder = java.util.Base64.getDecoder();
        byte[] decodedByte = decoder.decode(baseString.split(",")[1]);
        FileOutputStream fos = new FileOutputStream("MyAudio.webm");
        fos.write(decodedByte);
        fos.close();
	}
	
}
