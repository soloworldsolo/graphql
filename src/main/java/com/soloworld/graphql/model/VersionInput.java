package com.soloworld.graphql.model;

import java.util.Date;

public record VersionInput (String versionId, Integer gadgetId, Date releaseDate) {

}
