package com.example.cocos2d;

import org.cocos2d.actions.interval.CCJumpTo;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CGPoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	CCDirector ccDirector;
	CCScene ccScene;
	CCGLSurfaceView ccglSurfaceView;
	CCLayer ccLayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ccglSurfaceView = new CCGLSurfaceView(this);
		setContentView(ccglSurfaceView);
		ccDirector = CCDirector.sharedDirector();
		ccDirector.attachInView(ccglSurfaceView);
		ccDirector.setDisplayFPS(true);
		ccDirector.setAnimationInterval(1/30.0);
		ccScene=ccScene.node();
		ccLayer =new GameLayer();
		ccScene.addChild(ccLayer);
		ccDirector.runWithScene(ccScene);
	}
	class GameLayer extends CCLayer{
		CCSprite ccSprite;
		public GameLayer() {
			ccSprite = CCSprite.sprite("ic_launcher.png");
			ccSprite.setPosition(100,150);
			CCJumpTo ccJumpTo = CCJumpTo.action(4, CGPoint.ccp(400, 450), 200, 2);
			this.addChild(ccSprite);
			ccSprite.runAction(ccJumpTo);
		}
	}
}
