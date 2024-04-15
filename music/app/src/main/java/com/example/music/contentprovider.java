
import android.content.ContentProvider;
        import android.content.ContentUris;
        import android.content.ContentValues;
        import android.content.UriMatcher;
        import android.content.res.AssetFileDescriptor;
        import android.database.Cursor;
        import android.database.MatrixCursor;
        import android.net.Uri;
        import android.provider.BaseColumns;
        import android.util.Log;

        import java.io.FileNotFoundException;
        import java.util.HashMap;
        import java.util.Map;

public class music extends ContentProvider {

    private static final String TAG = "MusicContentProvider";

    // Authority for our content provider
    public static final String AUTHORITY = "com.yourpackage.musicprovider";

    // The content:// style URL for this provider
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // Uri matcher code for the whole table
    private static final int TABLE_DIR = 1;

    // Uri matcher code for a single row
    private static final int TABLE_ITEM = 2;

    // UriMatcher to match URIs with codes
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, "music", TABLE_DIR);
        sUriMatcher.addURI(AUTHORITY, "music/#", TABLE_ITEM);
    }

    // Music data hashmap
    private Map<Long, String> musicData;

    @Override
    public boolean onCreate() {
        // Initialize your music data here, replace this with your actual music data
        musicData = new HashMap<>();
        musicData.put(1L, "Song1.mp3");
        musicData.put(2L, "Song2.mp3");
        musicData.put(3L, "Song3.mp3");
        // Return true if the provider was successfully loaded
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        MatrixCursor cursor = new MatrixCursor(new String[]{BaseColumns._ID, "arrdee"});

        // Check if URI is for the whole table or a single row
        switch (sUriMatcher.match(uri)) {
            case TABLE_DIR:
                // If it's for the whole table, iterate through all songs
                for (Map.Entry<Long, String> entry : musicData.entrySet()) {
                    cursor.addRow(new Object[]{entry.getKey(), entry.getValue()});
                }
                break;
            case TABLE_ITEM:
                // If it's for a single row, get the song with the specified ID
                long id = ContentUris.parseId(uri);
                String songName = musicData.get(id);
                if (songName != null) {
                    cursor.addRow(new Object[]{id, songName});
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        return cursor;
    }

    // Implement other required methods like insert, update, delete based on your requirements

    @Override
    public String getType(Uri uri) {
        // Return the MIME type corresponding to a content URI
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // Implement insert if needed
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement delete if needed
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // Implement update if needed
        return 0;
    }

    @Override
    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        // Implement opening an asset file if needed
        return super.openAssetFile(uri, mode);
    }
}
