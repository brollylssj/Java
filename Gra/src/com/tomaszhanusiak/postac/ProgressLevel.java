package com.tomaszhanusiak.postac;

import com.tomaszhanusiak.opponent.Opponent;

public abstract class ProgressLevel {
	
	protected int lvlUp=100;
	abstract void progress(Postac postac);
	abstract void gainExperience(Opponent oponnent,Postac postac);


}
