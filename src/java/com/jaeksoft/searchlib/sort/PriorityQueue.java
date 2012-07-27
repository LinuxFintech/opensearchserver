/**   
 * License Agreement for OpenSearchServer
 *
 * Copyright (C) 2012 Emmanuel Keller / Jaeksoft
 * 
 * http://www.open-search-server.com
 * 
 * This file is part of OpenSearchServer.
 *
 * OpenSearchServer is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * OpenSearchServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with OpenSearchServer. 
 *  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.jaeksoft.searchlib.sort;

import com.jaeksoft.searchlib.result.ResultScoreDoc;
import com.jaeksoft.searchlib.util.Timer;

public class PriorityQueue {

	private SorterAbstract sorter;

	private java.util.PriorityQueue<ResultScoreDoc> queue;

	public PriorityQueue(SorterAbstract sorter, int capacity) {
		this.sorter = sorter;
		queue = new java.util.PriorityQueue<ResultScoreDoc>(capacity, sorter);
	}

	public void add(ResultScoreDoc doc) {
		queue.offer(doc);
	}

	public ResultScoreDoc[] getSortedElements(Timer timer) {
		ResultScoreDoc[] docs = new ResultScoreDoc[queue.size()];
		queue.toArray(docs);
		sorter.sort(docs, timer);
		return docs;
	}
}
