package models

import org.scalatest._
import scalikejdbc.scalatest.AutoRollback
import scalikejdbc._
import java.time.{OffsetDateTime}


class MembersSpec extends fixture.FlatSpec with Matchers with AutoRollback {
  val m = Members.syntax("m")

  behavior of "Members"

  it should "find by primary keys" in { implicit session =>
    val maybeFound = Members.find(1L)
    maybeFound.isDefined should be(true)
  }
  it should "find by where clauses" in { implicit session =>
    val maybeFound = Members.findBy(sqls.eq(m.id, 1L))
    maybeFound.isDefined should be(true)
  }
  it should "find all records" in { implicit session =>
    val allResults = Members.findAll()
    allResults.size should be >(0)
  }
  it should "count all records" in { implicit session =>
    val count = Members.countAll()
    count should be >(0L)
  }
  it should "find all by where clauses" in { implicit session =>
    val results = Members.findAllBy(sqls.eq(m.id, 1L))
    results.size should be >(0)
  }
  it should "count by where clauses" in { implicit session =>
    val count = Members.countBy(sqls.eq(m.id, 1L))
    count should be >(0L)
  }
  it should "create new record" in { implicit session =>
    val created = Members.create(createdAt = null)
    created should not be(null)
  }
  it should "save a record" in { implicit session =>
    val entity = Members.findAll().head
    // TODO modify something
    val modified = entity
    val updated = Members.save(modified)
    updated should not equal(entity)
  }
  it should "destroy a record" in { implicit session =>
    val entity = Members.findAll().head
    val deleted = Members.destroy(entity)
    deleted should be(1)
    val shouldBeNone = Members.find(1L)
    shouldBeNone.isDefined should be(false)
  }
  it should "perform batch insert" in { implicit session =>
    val entities = Members.findAll()
    entities.foreach(e => Members.destroy(e))
    val batchInserted = Members.batchInsert(entities)
    batchInserted.size should be >(0)
  }
}
