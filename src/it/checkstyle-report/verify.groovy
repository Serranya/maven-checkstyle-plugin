
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
import groovy.xml.XmlParser

assert new File(basedir, 'target/site/checkstyle.html').exists();

assert new File(basedir, 'target/checkstyle-cachefile').exists();
assert new File(basedir, 'target/checkstyle-checker.xml').exists();
assert new File(basedir, 'target/checkstyle-header.txt').exists();
assert new File(basedir, 'target/checkstyle-result.xml').exists();

File rssFile = new File( basedir, 'target/site/checkstyle.rss' );
assert rssFile.exists();

def rss = new XmlParser().parse( rssFile );

def channel = rss.channel[0]

assert channel.title.text() == 'check-pass - Checkstyle report'

def item = channel.item[0]
assert item != null
assert item.title.text().startsWith('File: 1,')


return true;