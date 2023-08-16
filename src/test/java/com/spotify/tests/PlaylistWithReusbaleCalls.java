package com.spotify.tests;

import org.testng.annotations.Test;

import com.spotify.pojo.CreatePlaylistRequest;

import api.PlaylistAPICalls;
import authManager.TokenGenerator;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojo.CreateUserRequestBody;

public class PlaylistWithReusbaleCalls {
	static String playListId;

//	@Test(priority = 0)
//	public void getAccessToken() {
//
//	  String accessToken = PlaylistAPICalls.getAccessTokenFromRefreshToken();
//		PlaylistAPICalls playlistAPICalls=new PlaylistAPICalls(accessToken);
//
//	}

	@Test(priority = 1)
	public void createPlaylist() {
		CreatePlaylistRequest reqPlaylist = new CreatePlaylistRequest();
		reqPlaylist.setName("Rastrgit Songs for me_16_August");
		reqPlaylist.setDescription("Sprictual Content of Rastragit_16_August");
		reqPlaylist.setPublic(false);

		Response response = PlaylistAPICalls.postRequest(reqPlaylist, TokenGenerator.renewToken());

		CreatePlaylistRequest responsePlaylist = response.as(CreatePlaylistRequest.class);

		playListId = responsePlaylist.getId();

		String requestName = reqPlaylist.getName();
		String responseName = responsePlaylist.getName();

		Assert.assertEquals(responseName, requestName);

	}

	@Test(priority = 2)
	public void getAPlaylist() {
		Response response = PlaylistAPICalls.getRequest(playListId, TokenGenerator.renewToken());
		CreatePlaylistRequest responsePlayList = response.as(CreatePlaylistRequest.class);

		String description = responsePlayList.getDescription();

		System.out.println("Description is:" + description);
	}

	@Test(priority = 3)
	public void updateAPlaylist() {

		CreatePlaylistRequest reqPlaylist = new CreatePlaylistRequest();
		reqPlaylist.setName("Rastrgit Songs for me_16_August_Updtae_Request");
		reqPlaylist.setDescription("Sprictual Content of Rastragit_16_August_Updtae_Request");
		reqPlaylist.setPublic(false);

		Response response = PlaylistAPICalls.updateRequest(reqPlaylist, playListId, TokenGenerator.renewToken());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 4)
	public void shouldNotbeAuthorized() {
		CreatePlaylistRequest reqPlaylist = new CreatePlaylistRequest();
		reqPlaylist.setName("Rastrgit Songs for me_15_August");
		reqPlaylist.setDescription("Sprictual Content of Rastragit_15_August");
		reqPlaylist.setPublic(false);

		Response response = PlaylistAPICalls.postRequest(reqPlaylist,
				"Bearer BQCftoxo9W_Hbk5F4CUnbkt4ZbjRwsiGukmPkBIOtjtHTYZjstcARTly2cDIRLOab67qZVYCxR4Kj-On_JmBbJHVqRsnJrggQWT0jmN4VQtAUAuCzmRxxnMN12v-j2TDdFd8aBgPTrRnfz3o88vh4la14bJut1g5gOEyZ9e73EeRXKSBYl4PNLH-shhHtZlCZ2oYaDUl8DtCdH-P6Q82Nug3pRqCcc-QRDgonDnf8Mvn8McQ2Y2ukjsFmux40peQhmp47bQI2IlZQ_eW");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(401, statusCode);

	}
}
