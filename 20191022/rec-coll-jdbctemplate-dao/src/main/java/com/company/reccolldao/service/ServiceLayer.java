package com.company.reccolldao.service;

import com.company.reccolldao.dao.AlbumDao;
import com.company.reccolldao.dao.ArtistDao;
import com.company.reccolldao.dao.LabelDao;
import com.company.reccolldao.dao.TrackDao;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Autowired
    public ServiceLayer(AlbumDao albumDao, ArtistDao artistDao, LabelDao labelDao, TrackDao trackDao) {
        this.albumDao = albumDao;
        this.artistDao = artistDao;
        this.labelDao = labelDao;
        this.trackDao = trackDao;
    }

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel albumViewModel) {

        // First - save the album part
        Album album = new Album();
        album.setTitle(albumViewModel.getTitle());
        album.setReleaseDate(albumViewModel.getReleaseDate());
        album.setListPrice(albumViewModel.getListPrice());
        album.setArtistId(albumViewModel.getArtist().getId());
        album.setLabelId(albumViewModel.getLabel().getId());

        album = albumDao.addAlbum(album);

        albumViewModel.setId(album.getId());

        // We only allow our users to create albums where the artist and label already exist.

        // handle the tracks
        List<Track> tracks = albumViewModel.getTracks();

        tracks.stream()
                .forEach(t ->
                        {
                            t.setAlbumId(albumViewModel.getId());
                            trackDao.addTrack(t);
                        });

        tracks = trackDao.getTracksByAlbum(albumViewModel.getId());
        albumViewModel.setTracks(tracks);

        return albumViewModel;
    }

    @Transactional
    public void updateAlbum(AlbumViewModel avm) {

        // Update the album information
        Album album = new Album();

        album.setId(avm.getId());
        album.setTitle(avm.getTitle());
        album.setReleaseDate(avm.getReleaseDate());
        album.setListPrice(avm.getListPrice());
        album.setArtistId(avm.getArtist().getId());
        album.setLabelId(avm.getLabel().getId());

        albumDao.updateAlbum(album);

        // delete all the tracks associated with this album
        List<Track> oldTrackList = trackDao.getTracksByAlbum(avm.getId());
        oldTrackList.stream()
                .forEach(track -> trackDao.deleteTrack(track.getId()));

        List<Track> newTrackList = avm.getTracks();
        newTrackList.stream()
                .forEach(t ->
                {
                    t.setAlbumId(avm.getId());
                    trackDao.addTrack(t);
                });
    }

    @Transactional
    public void deleteAlbum(int id) {
        List<Track> tracksToRemove = trackDao.getTracksByAlbum(id);

        tracksToRemove.stream()
                .forEach(t -> trackDao.deleteTrack(t.getId()));

        albumDao.deleteAlbum(id);
    }

    public List<AlbumViewModel> findAllAlbums() {
        List<Album> albums = albumDao.getAllAlbums();

        List<AlbumViewModel> avmList = new ArrayList<>();

//        for (int i = 0; i < albums.size(); i++) {
//            AlbumViewModel avm = buildViewModel(albums.get(i));
//            avmList.add(avm);
//        }
//

//        for (Album album : albums) {
//            avmList.add(buildViewModel(album));
//        }

        albums.forEach(album -> avmList.add(buildViewModel(album)));

        return avmList;
    }


    public AlbumViewModel findAlbum(int id) {
        // Get the album out of the database
        Album album = albumDao.getAlbum(id);

        return buildViewModel(album);
    }

    public AlbumViewModel buildViewModel(Album album) {
        Artist artist = artistDao.getArtist(album.getArtistId());

        Label label = labelDao.getLabel(album.getLabelId());

        List<Track> tracks = trackDao.getTracksByAlbum(album.getId());

        AlbumViewModel returnVal = new AlbumViewModel();
        returnVal.setId(album.getId());
        returnVal.setTitle(album.getTitle());
        returnVal.setListPrice(album.getListPrice());
        returnVal.setReleaseDate(album.getReleaseDate());
        returnVal.setArtist(artist);
        returnVal.setLabel(label);
        returnVal.setTracks(tracks);

        return returnVal;
    }

    //artist
    public Artist addArtist(Artist artist) {
        return artistDao.addArtist(artist);
    }

    public void deleteArtist(int artistId) {
        artistDao.deleteArtist(artistId);
    }

    public void updateArtist(Artist artist) {
        artistDao.updateArtist(artist);
    }

    public Artist getArtist(int id) {
        return artistDao.getArtist(id);
    }

    public List<Artist> getAllArtists() {
        return artistDao.getAllArtists();
    }

    //label

    public Label addLabel(Label label) {return labelDao.addLabel(label);}

    public void deleteLabel(int labelId) { labelDao.deleteLabel(labelId);}

    public Label updateLabel(Label label) { labelDao.updateLabel(label);
        return label;
    }

    public Label getLabel(int id) {return labelDao.getLabel(id);}

    public List<Label> getAllLabels() { return labelDao.getAllLabels();}

    //album

    public Album addAlbum (Album album) {return  albumDao.addAlbum(album);}

    public void deleteAlbum1 (int albumId) { albumDao.deleteAlbum(albumId);}

    public void updateAlbum(Album album) {albumDao.updateAlbum(album);}

    public Album getAlbum(int id) {return albumDao.getAlbum(id);}

    public List<Album> getAllAlbums() {return albumDao.getAllAlbums();}






    public AlbumDao getAlbumDao() {
        return albumDao;
    }

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public ArtistDao getArtistDao() {
        return artistDao;
    }

    public void setArtistDao(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    public LabelDao getLabelDao() {
        return labelDao;
    }

    public void setLabelDao(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    public TrackDao getTrackDao() {
        return trackDao;
    }

    public void setTrackDao(TrackDao trackDao) {
        this.trackDao = trackDao;
    }
}
