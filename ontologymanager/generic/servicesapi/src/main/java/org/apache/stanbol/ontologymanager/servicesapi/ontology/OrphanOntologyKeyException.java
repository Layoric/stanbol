/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.stanbol.ontologymanager.servicesapi.ontology;

import org.semanticweb.owlapi.model.OWLOntologyID;

/**
 * Thrown when no match is found between a public key of an ontology that was supposed to be stored and the
 * stored graphs. This public key is then called <i>orphan</i>.
 * 
 * @author alexdma
 * 
 */
public class OrphanOntologyKeyException extends RuntimeOntologyException {

    /**
     * 
     */
    private static final long serialVersionUID = -2841412277788505762L;

    /**
     * Creates a new instance of {@link OrphanOntologyKeyException} with the supplied orphan key.
     * 
     * @param key
     *            the orphan ontology key.
     */
    public OrphanOntologyKeyException(OWLOntologyID orphan) {
        super(orphan);
    }

}
