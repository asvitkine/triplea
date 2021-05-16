package games.strategy.triplea.ai.pro.data;

import games.strategy.engine.data.Route;
import games.strategy.engine.data.Territory;
import games.strategy.engine.data.Unit;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Getter;

/** The result of an AI amphibious movement analysis. */
@Getter
public class ProTransport {

  private final Unit transport;
  private final Map<Territory, Set<Route>> transportMap;
  private final Map<Territory, Set<Route>> seaTransportMap;

  ProTransport(final Unit transport) {
    this.transport = transport;
    transportMap = new HashMap<>();
    seaTransportMap = new HashMap<>();
  }

  void addTerritories(
      final Set<Territory> attackTerritories, final Collection<Route> myUnitsToLoadRoutes) {
    for (final Territory attackTerritory : attackTerritories) {
      transportMap.computeIfAbsent(attackTerritory, k -> new HashSet<>()).addAll(myUnitsToLoadRoutes);
    }
  }

  void addSeaTerritories(
      final Set<Territory> attackTerritories, final Collection<Route> myUnitsToLoadRoutes) {
    for (final Territory attackTerritory : attackTerritories) {
      seaTransportMap.computeIfAbsent(attackTerritory, k -> new HashSet<>()).addAll(myUnitsToLoadRoutes);
    }
  }
}
