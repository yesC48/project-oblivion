package oblivion.blocks.defense;

import mindustry.entities.*;
import mindustry.world.blocks.defense.*;

public class ExplosiveWall extends Wall {
	public float damage = 1f, range = 80f;
	public float flammability = 0f;

	public ExplosiveWall(String name) {
		super(name);
	}

	public class ExplosiveWallBuild extends WallBuild {
		@Override
		public void onDestroyed() {
			super.onDestroyed();
			Damage.damage(team, x, y, range, damage);
			if(flammability > 0f) {Damage.createIncend(x, y, range, (int) flammability * 10f);}
			Damage.dynamicExplosion(x, y, 0f, 0f, 0f, range/10f, false, false, null, destroyEffect);
		}
	}
}