package com.centrifugal.centrifuge.android.message.history;

import org.json.JSONObject;

import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This file is part of ACentrifugo.
 *
 * ACentrifugo is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ACentrifugo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with ACentrifugo.  If not, see <a href="http://www.gnu.org/licenses/">http://www.gnu.org/licenses/</a>.
 *
 * Created by Semyon on 04.05.2016.
 */
public class HistoryItem {

    @Nonnull
    private String UUID;

    @Nonnull
    private Date timestamp;

    @Nonnull
    private String channel;

    @Nullable
    private JSONObject data;

    public HistoryItem(@Nonnull final JSONObject messageJSON) {
        data = messageJSON.optJSONObject("data");
        UUID = messageJSON.optString("uid");
        channel = messageJSON.optString("channel");
        String timestampString = messageJSON.optString("timestamp");
        timestamp = new Date(Long.valueOf(timestampString));
    }

    @Nonnull
    public String getUUID() {
        return UUID;
    }

    @Nonnull
    public Date getTimestamp() {
        return timestamp;
    }

    @Nonnull
    public String getChannel() {
        return channel;
    }

    @Nullable
    public JSONObject getData() {
        return data;
    }

}