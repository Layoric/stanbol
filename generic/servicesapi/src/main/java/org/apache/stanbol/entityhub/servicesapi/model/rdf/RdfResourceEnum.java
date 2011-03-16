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
package org.apache.stanbol.entityhub.servicesapi.model.rdf;

import org.apache.stanbol.entityhub.servicesapi.defaults.NamespaceEnum;

public enum RdfResourceEnum {
    /**
     * The representation concept
     */
    Representation,
    /**
     * The Sign concept
     */
    Sign,
    /**
     * The field used to store the type of the representation
     */
    signType,
    /**
     * The site that defines/manages a sign
     */
    signSite,
    /**
     * The ranking of the entity by this site in the value range of [0..1]
     * A sign with the rank 1 would be (one of) the most important entities
     * managed by this Site. A sign with rank 0 has no relevance. Even that this
     * is still within the value range one could wonder why this site does
     * even manage a representation about that entity.
     */
    signRank,
    /**
     * The representation of the Sign (domain=Sign, range=Representation).
     */
    signRepresentation,
    /**
     * The Symbol concept
     */
    Symbol,
    /**
     * The label of a Symbol
     */
    label,
    /**
     * The description of a Symbol
     */
    description,
    /**
     * Predecessors of a Symbol
     */
    predecessor,
    /**
     * Successors of a Symbol
     */
    successor,
    /**
     * The property used for the state of the symbol
     */
    hasSymbolState,
    /**
     * The Concept used to type instances of SymbolStates
     */
    SymbolState,
    /**
     * The Individual representing the active state of a Symbol
     */
    symbolStateActive(null,"symbolState-active"),
    /**
     * The Individual representing the depreciated state of a Symbol
     */
    symbolStateDepreciated(null,"symbolState-depreciated"),
    /**
     * The Individual representing the proposed state of a Symbol
     */
    symbolStateProposed(null,"symbolState-proposed"),
    /**
     * The Individual representing the removed state of a Symbol
     */
    symbolStateRemoved(null,"symbolState-removed"),
    /**
     * Property used to reference MappedEntites mapped to a Symbol
     */
    hasMapping,
    /**
     * A EntityMapping that links an Entity to a Symbol
     */
    EntityMapping,
    /**
     * Property used to reference the mapped entity.
     */
    mappedEntity,
    /**
     * Property used to reference the mapped symbol
     */
    mappedSymbol,
    /**
     * The property used for the state of the MappedEntity
     */
    hasMappingState,
    /**
     * The expires date of a representation
     */
    expires,
    /**
     * The Concept used to type instances of mapping states
     */
    MappingState,
    /**
     * The Individual representing the confirmed state of MappedEntities
     */
    mappingStateConfirmed(null,"mappingState-confirmed"),
    /**
     * The Individual representing the expired state of MappedEntities
     */
    mappingStateExpired(null,"mappingState-expired"),
    /**
     * The Individual representing the proposed state of MappedEntities
     */
    mappingStateProposed(null,"mappingState-proposed"),
    /**
     * The Individual representing the rejected state of MappedEntities
     */
    mappingStateRejected(null,"mappingState-rejected"),
    /**
     * The Individual representing the result set of an field query
     */
    QueryResultSet(NamespaceEnum.entityhubQuery),
    /**
     * The property used to link from the {@link #QueryResultSet} to the
     * {@link org.apache.stanbol.entityhub.servicesapi.model.Representation} nodes.
     */
    queryResult(NamespaceEnum.entityhubQuery),
    /**
     * The score of the result in respect to the parsed query.
     */
    resultScore(NamespaceEnum.entityhubQuery,"score"),
    /**
     * The id of the site the result was found
     */
    resultSite(NamespaceEnum.entityhubQuery),
    /**
     * The data type URI for the {@link org.apache.stanbol.entityhub.servicesapi.model.Reference}
     * interface. Used  entityhub-model:ref
     */
    ReferenceDataType(null,"ref"),
    /**
     * The data type URI for the {@link org.apache.stanbol.entityhub.servicesapi.model.Text}
     * interface. Uses entityhub-model:text
     */
    TextDataType(null,"text"),
    ;
    private String uri;
    /**
     * Initialise a new property by using the parse URI. If <code>null</code> is
     * parsed, the URI is generated by using the Entityhub model namespace (
     * {@link NamespaceEnum#entityhubModel}).
     * @param uri the uri of the element
     */
    private RdfResourceEnum(String uri) {
        if(uri == null){
            this.uri = NamespaceEnum.entityhubModel+name();
        }
        this.uri = uri;
    }
    /**
     * Initialise a new property with the namespace and the {@link #name()} as
     * local name.
     * @param ns the namespace of the property or <code>null</code> to use the
     * default namespace
     */
    private RdfResourceEnum(NamespaceEnum ns){
        this(ns,null);
    }
    /**
     * Initialise a new property with the parsed namespace and local name.
     * @param ns the namespace of the property or <code>null</code> to use the
     * default namespace
     * @param localName the local name of the property or <code>null</code> to
     * use the {@link #name()} as local name.
     */
    private RdfResourceEnum(NamespaceEnum ns,String localName){
        String uri;
        if(ns == null){
            uri = NamespaceEnum.entityhubModel.getNamespace();
        } else {
            uri = ns.getNamespace();
        }
        if(localName == null){
            uri = uri+name();
        } else {
            uri = uri+localName;
        }
        this.uri = uri;
    }
    /**
     * Initialise a new property with {@link NamespaceEnum#entityhubModel}) as namespace
     * and the {@link #name()} as local name.
     */
    private RdfResourceEnum(){
        this(null,null);
    }
    /**
     * Getter for the Unicode character of the URI
     * @return
     */
    public String getUri(){
        return uri;
    }
    @Override
    public String toString() {
        return uri;
    }

}
