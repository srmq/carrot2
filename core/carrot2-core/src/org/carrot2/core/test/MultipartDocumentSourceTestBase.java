package org.carrot2.core.test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.carrot2.core.DocumentSource;
import org.carrot2.source.*;
import org.carrot2.source.MultipageSearchEngine.SearchMode;
import org.junit.Test;
import org.junitext.Prerequisite;

/**
 * Common tests for {@link DocumentSource}s that can make more than one search requests to
 * get results for one query.
 */
public abstract class MultipartDocumentSourceTestBase<T extends DocumentSource> extends
    QueryableDocumentSourceTestBase<T>
{
    /**
     * Metadata for the {@link MultipageSearchEngine} being tested.
     */
    protected abstract MultipageSearchEngineMetadata getSearchEngineMetadata();

    @Test
    @Prerequisite(requires = "externalApiTestsEnabled")
    public void testQueryLargerThanPage() throws Exception
    {
        final int needed = getSearchEngineMetadata().resultsPerPage * 2
            + getSearchEngineMetadata().resultsPerPage / 2;

        // Allow some slack (duplicated URLs).
        final int documentsReturned = runQuery("test", needed);

        assertThat(documentsReturned).isGreaterThan(needed - 10);
    }

    @Test
    @Prerequisite(requires = "externalApiTestsEnabled")
    public void testConservativeMode() throws Exception
    {
        processingAttributes.put("search-mode", SearchMode.CONSERVATIVE);

        runAndCheckNoResultsQuery();
        assertEquals(1, processingAttributes.get(SearchEngineStats.class.getName()
            + ".pageRequests"));
    }

    @Test
    @Prerequisite(requires = "externalApiTestsEnabled")
    public void testSpeculativeMode() throws Exception
    {
        processingAttributes.put("search-mode", SearchMode.SPECULATIVE);

        runAndCheckNoResultsQuery(getSearchEngineMetadata().resultsPerPage + 1);
        assertEquals(2, processingAttributes.get(SearchEngineStats.class.getName()
            + ".pageRequests"));
    }
}
