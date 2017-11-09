package model.interfaces;

import model.exceptions.InsufficientBalance;

public interface CompteManip extends CompteItf
{
	double withdraw (double amount) throws InsufficientBalance;
}