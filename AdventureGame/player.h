/* 
 * File:   player.h
 * Author: Stephen
 *
 * Created on 13 February 2019, 18:16
 */

#ifndef PLAYER_H
#define	PLAYER_H
#include <string>

class Player
{
public:
	Player(const std::string& name, int hp, int acc,
		int xp, int armor, const std::string& weaponName,
		int lowDamage, int highDamage, int gold);
        
        bool isDead();
	int getGold();
        void addGold(int gold);
	int getXP();
        void addXP(int xp);
	std::string getName();
	int getArmor();
	void takeDamage(int damage);

private:
	std::string mName;
	std::string mWeaponName;

	int         mDamageHigh;
	int         mDamageLow;
	int         mHitPoints;
	int         mAccuracy;
	int         mExp;
	int         mArmor;
	int         mGold;
};

#endif //PLAYER.h