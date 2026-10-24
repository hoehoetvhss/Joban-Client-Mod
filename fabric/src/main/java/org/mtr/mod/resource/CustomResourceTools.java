package org.mtr.mod.resource;

import org.mtr.mapping.holder.Identifier;

public interface CustomResourceTools extends org.mtr.resource.CustomResourceTools {
    static Identifier formatIdentifier(String resource, String extension) {
        return new Identifier(org.mtr.resource.CustomResourceTools.formatIdentifier(resource, extension));
    }

    static Identifier formatIdentifierWithDefault(String resource, String extension) {
        return new Identifier(org.mtr.resource.CustomResourceTools.formatIdentifierWithDefault(resource, extension));
    }
}
