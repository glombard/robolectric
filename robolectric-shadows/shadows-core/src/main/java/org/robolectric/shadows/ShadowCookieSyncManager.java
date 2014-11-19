package org.robolectric.shadows;

import android.content.Context;
import android.webkit.CookieSyncManager;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.internal.Shadow;

/**
 * Shadows the {@code android.webkit.CookieSyncManager} class.
 */
@Implements(CookieSyncManager.class)
public class ShadowCookieSyncManager extends ShadowWebSyncManager {

  private static CookieSyncManager sRef;

  @Implementation
  public static synchronized CookieSyncManager createInstance(Context ctx) {
    if (sRef == null) {
      sRef = Shadow.newInstanceOf(CookieSyncManager.class);
    }
    return sRef;
  }

  @Implementation
  public static CookieSyncManager getInstance() {
    if (sRef == null) {
      throw new IllegalStateException("createInstance must be called first");
    }
    return sRef;
  }
}