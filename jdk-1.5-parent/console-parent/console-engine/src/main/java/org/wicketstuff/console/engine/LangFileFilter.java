/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wicketstuff.console.engine;

import java.io.File;
import java.io.FilenameFilter;

/**
 * File filter for files of a given {@link Lang}.
 * <p>
 * Use {@link #create(Lang)} to create a specific one.
 * 
 * @author cretzel
 */
public class LangFileFilter implements FilenameFilter {

	private final String suffix;

	private LangFileFilter(final String ext) {
		suffix = ext;
	}

	public boolean accept(final File dir, final String name) {
		return name.toLowerCase().endsWith(suffix);
	}

	public static LangFileFilter create(final Lang lang) {
		switch (lang) {
		case GROOVY:
			return new GroovyFileFilter();
		case CLOJURE:
			return new ClojureFileFilter();
		default:
			throw new IllegalArgumentException("Lang " + lang + "not supported");
		}
	}

	public static class GroovyFileFilter extends LangFileFilter {

		public GroovyFileFilter() {
			super(Lang.GROOVY.getFileExtension());
		}

	}

	public static class ClojureFileFilter extends LangFileFilter {

		public ClojureFileFilter() {
			super(Lang.CLOJURE.getFileExtension());
		}

	}
}