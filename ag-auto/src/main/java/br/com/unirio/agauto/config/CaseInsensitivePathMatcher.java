package br.com.unirio.agauto.config;

import java.util.Map;

import org.springframework.util.AntPathMatcher;

public class CaseInsensitivePathMatcher extends AntPathMatcher {
	protected boolean doMatch(String pattern, String path, boolean fullMatch, Map<String, String> uriTemplateVariables) {
        return super.doMatch(pattern.toLowerCase(), path.toLowerCase(), fullMatch, uriTemplateVariables);
    }
}
