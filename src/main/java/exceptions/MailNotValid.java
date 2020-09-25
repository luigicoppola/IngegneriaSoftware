/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

public class MailNotValid extends Exception {
	public MailNotValid(String msg) {
		super(msg);
	}
}