package com.study.en.utils;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 3DES加密工具类
 */
public class Des3 {

	public static void main(String[] args) throws Exception {

		String ip = "192.168.88.98";
        String bef = 108 + ","+ ip;
        System.out.println(bef);
        String encode = encode(String.valueOf(bef));
        System.out.println(encode);
		System.out.println(decode(encode));
    }

	/**
	 * 解密id
	 * @param str
	 * @return
	 */
	public static Integer decryptId (String str){
        try {
            if (StringUtils.isNotEmpty(str)){
                if (str.length()-str.indexOf("=") <= 2){
                   return Integer.parseInt(decode(str));
                }
            }
            return null;
        }catch (Exception e){
            return null;
        }
	}

	// 密钥
	private final static String secretKey = "byit_visit_a23ijhas33dkadgj2345sd2352jhb";
	// 向量
	private final static String iv = "01234567";
	// 加解密统一使用的编码方式
	private final static String encoding = "utf-8";

	public static String encode(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, createKey(), ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Encodes.encodeUrlSafeBase64(encryptData);
	}

	public static Key createKey() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {// 创建密钥
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		Key deskey = keyfactory.generateSecret(spec);
		return deskey;
	}

	public static String decode(String encryptText) throws Exception {
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, createKey(), ips);
		byte[] decryptData = cipher.doFinal(Encodes.decodeBase64(encryptText));
		return new String(decryptData, encoding);
	}
}