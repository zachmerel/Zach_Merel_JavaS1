package com.company.reccolldao.service;

import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Before
    public void setUp() throws Exception {
        setUpAlbumDaoMock();
        setUpArtistDaoMock();
        setUpLabelDaoMock();
        setUpTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);

    }

    @Test
    public void saveFindAlbum() {
        AlbumViewModel avm = new AlbumViewModel();

        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));
        avm.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("test label");
        label.setWebsite("testlabel.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setRunTime(142);
        track.setTitle("Something");
        List<Track> tList = new ArrayList<>();
        tList.add(track);

        avm.setTracks(tList);

        avm = service.saveAlbum(avm);

        AlbumViewModel fromService = service.findAlbum(avm.getId());

        assertEquals(avm, fromService);

    }

    @Test
    public void findAllAlbums() {
        AlbumViewModel avm = new AlbumViewModel();


        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));
        avm.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("test label");
        label.setWebsite("testlabel.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setRunTime(142);
        track.setTitle("Something");
        List<Track> tList = new ArrayList<>();
        tList.add(track);

        avm.setTracks(tList);

        avm.setId(1);
        avm.getTracks().get(0).setId(123);
        avm.getTracks().get(0).setAlbumId(1);
        List<AlbumViewModel> listWeExpect= new ArrayList<>();
        listWeExpect.add(avm);

        //act
        List<AlbumViewModel> theThingIGot = service.findAllAlbums();



        //assert
        assertEquals(listWeExpect,theThingIGot);
        assertEquals(1, theThingIGot.size());

    }

    @Test
    public void saveFindFindAllArtist() {

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        artist = service.saveArtist(artist);
        Artist fromService = service.findArtist(artist.getId());
        assertEquals(artist, fromService);

        List<Artist> aList = service.findAllArtists();
        assertEquals(1, aList.size());
        assertEquals(artist, aList.get(0));
    }

    @Test
    public void saveFindFindAllLabel() {

        Label label = new Label();
        label.setName("test label");
        label.setWebsite("testlabel.com");

        label = service.saveLabel(label);
        Label fromService = service.findLabel(label.getId());
        assertEquals(label,fromService);

        List<Label> aList = service.findAllLabels();
        assertEquals(1,aList.size());
        assertEquals(label,aList.get(0));

    }

    // Helper methods
    private void setUpAlbumDaoMock() {
        albumDao = mock(AlbumDaoJdbcTemplateImpl.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumDao).addAlbum(album2);
        doReturn(album).when(albumDao).getAlbum(1);
        doReturn(aList).when(albumDao).getAllAlbums();
    }

    private void setUpArtistDaoMock() {
        artistDao = mock(ArtistDaoJdbcTemplateImpl.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = new Artist();
        artist2.setInstagram("@RockStar");
        artist2.setName("The GOAT");
        artist2.setTwitter("@TheRockStar");


        List<Artist> aList = new ArrayList<>();
        aList.add(artist);

        doReturn(artist).when(artistDao).addArtist(artist2);
        doReturn(artist).when(artistDao).getArtist(45);
        doReturn(aList).when(artistDao).getAllArtists();

    }

    private void setUpLabelDaoMock() {
        labelDao = mock(LabelDaoJdbcTemplateImpl.class);
        Label label = new Label();
        label.setId(10);
        label.setName("test label");
        label.setWebsite("testlabel.com");

        Label label2 = new Label();
        label2.setName("test label");
        label2.setWebsite("testlabel.com");

        List<Label> aList = new ArrayList<>();
        aList.add(label);

        doReturn(label).when(labelDao).addLabel(label2);
        doReturn(label).when(labelDao).getLabel(10);
        doReturn(aList).when(labelDao).getAllLabels();


    }

    private void setUpTrackDaoMock() {
        trackDao = mock(TrackDaoJdbcTemplateImpl.class);
        Track track = new Track();
        track.setId(123);
        track.setAlbumId(1);
        track.setRunTime(142);
        track.setTitle("Something");

        Track track2 = new Track();
        track2.setAlbumId(1);
        track2.setRunTime(142);
        track2.setTitle("Something");

        List<Track> aList = new ArrayList<>();
        aList.add(track);

        doReturn(track).when(trackDao).addTrack(track2);
        doReturn(track).when(trackDao).getTrack(123);
        doReturn(aList).when(trackDao).getAllTracks();
        doReturn(aList).when(trackDao).getTracksByAlbum(1);


    }
}