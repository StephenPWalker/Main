// Monster.h

#ifndef MONSTER_H
#define MONSTER_H
#include <string>

// "Forward class declaration" so that we can use the Player
// class without having defined it yet.  This idea is 
// similar to a function declaration.

class Monster;

class Monster
{
public:
	Monster(const std::string& name, int hp, int acc,
		int xpReward, int armor, const std::string& weaponName,
		int lowDamage, int highDamage, int goldReward);
        
        bool isDead();
	int getGoldReward();
	int getXPReward();
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
	int         mExpReward;
	int         mArmor;
	int         mGoldReward;
};

#endif //MONSTER_H