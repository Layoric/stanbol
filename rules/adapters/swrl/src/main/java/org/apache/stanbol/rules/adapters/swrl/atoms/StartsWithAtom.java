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
package org.apache.stanbol.rules.adapters.swrl.atoms;

import java.util.ArrayList;
import java.util.List;

import org.apache.stanbol.rules.adapters.AbstractAdaptableAtom;
import org.apache.stanbol.rules.adapters.swrl.ArgumentSWRLAtom;
import org.apache.stanbol.rules.adapters.swrl.HigherOrderSWRLAtom;
import org.apache.stanbol.rules.base.api.RuleAtom;
import org.apache.stanbol.rules.base.api.RuleAtomCallExeption;
import org.apache.stanbol.rules.base.api.UnavailableRuleObjectException;
import org.apache.stanbol.rules.base.api.UnsupportedTypeForExportException;
import org.apache.stanbol.rules.manager.atoms.ExpressionAtom;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.SWRLArgument;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLDArgument;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.vocab.SWRLBuiltInsVocabulary;

/**
 * It adapts any StartsWithAtom to the <http://www.w3.org/2005/xpath-functions#starts-with> XPath function in
 * SWRL.
 * 
 * @author anuzzolese
 * 
 */
public class StartsWithAtom extends AbstractAdaptableAtom {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T adapt(RuleAtom ruleAtom) throws RuleAtomCallExeption,
                                         UnavailableRuleObjectException,
                                         UnsupportedTypeForExportException {

        org.apache.stanbol.rules.manager.atoms.StartsWithAtom tmp = (org.apache.stanbol.rules.manager.atoms.StartsWithAtom) ruleAtom;

        ExpressionAtom argument = tmp.getArgument();
        ExpressionAtom term = tmp.getTerm();

        OWLDataFactory factory = OWLManager.getOWLDataFactory();

        SWRLAtom swrlAtom1 = (SWRLAtom) adapter.adaptTo(argument, SWRLRule.class);
        SWRLAtom swrlAtom2 = (SWRLAtom) adapter.adaptTo(term, SWRLRule.class);

        SWRLDArgument swrldArgument1;
        SWRLDArgument swrldArgument2;

        List<SWRLAtom> listOfArguments = new ArrayList<SWRLAtom>();

        if (swrlAtom1 instanceof HigherOrderSWRLAtom) {
            swrldArgument1 = ((HigherOrderSWRLAtom) swrlAtom1).getBindableArgument();

            listOfArguments.addAll(((HigherOrderSWRLAtom) swrlAtom1).getAtoms());
        } else if (swrlAtom1 instanceof ArgumentSWRLAtom) {
            SWRLArgument swrlArgument = ((ArgumentSWRLAtom) swrlAtom1).getSwrlArgument();
            swrldArgument1 = (SWRLDArgument) swrlArgument;
        } else {
            throw new org.apache.stanbol.rules.base.api.RuleAtomCallExeption(getClass());
        }

        if (swrlAtom2 instanceof HigherOrderSWRLAtom) {
            swrldArgument2 = ((HigherOrderSWRLAtom) swrlAtom2).getBindableArgument();

            listOfArguments.addAll(((HigherOrderSWRLAtom) swrlAtom2).getAtoms());
        } else if (swrlAtom2 instanceof ArgumentSWRLAtom) {
            SWRLArgument swrlArgument = ((ArgumentSWRLAtom) swrlAtom2).getSwrlArgument();
            swrldArgument2 = (SWRLDArgument) swrlArgument;
        } else {
            throw new org.apache.stanbol.rules.base.api.RuleAtomCallExeption(getClass());
        }

        List<SWRLDArgument> swrldArguments = new ArrayList<SWRLDArgument>();
        swrldArguments.add(swrldArgument1);
        swrldArguments.add(swrldArgument2);

        return (T) factory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.STARTS_WITH.getIRI(), swrldArguments);

    }

}
